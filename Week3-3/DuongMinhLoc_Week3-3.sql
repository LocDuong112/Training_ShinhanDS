-- Bai 1

-- Question 1
create or replace procedure dept_info (dept_id in departments.department_id%type, dept out departments%Rowtype) is
    begin
        select * into dept from departments where departments.department_id=dept_id;
    end; 
    
declare
    dept departments%rowtype;
begin
    dept_info(10, dept);
    dbms_output.put_line(dept.department_name); -- Administration
end;
    
-- Question 2
create or replace 
procedure add_job(job_id in jobs.job_id%type, job_title in jobs.job_title%type) is
    begin
        insert into jobs(job_id, job_title) values (job_id, job_title);
    end;
    
declare
    job_id jobs.job_id%type := 'test_id';
    job_title jobs.job_title%type := 'test_title';
    job_title_result jobs.job_title%type;
begin
    add_job(job_id, job_title);
    select jobs.job_title into job_title_result from jobs where jobs.job_id='test_id';
    dbms_output.put_line(job_title_result); -- test_title
end;
    
-- Question 3
create or replace
procedure update_comm(emp_id in employees.employee_id%type) is
    begin
        update employees
        set employees.commission_pct = 1.05 * employees.commission_pct
        where emp_id = employees.employee_id;
    end;
    
declare
    emp_id employees.employee_id%type := 160;
    com_result employees.commission_pct%type;
begin
    select employees.commission_pct into com_result 
    from employees 
    where employees.employee_id=emp_id;
    dbms_output.put_line('commission before ' || com_result);
    
    update_comm(emp_id);
    
    select employees.commission_pct into com_result 
    from employees 
    where employees.employee_id=emp_id;
    dbms_output.put_line('commission after ' || com_result);
end;

-- Question 4
create or replace 
procedure add_emp(emp in employees%rowtype) is
    begin
        insert into employees values emp;
    end;
    
-- Question 5
create or replace
procedure delete_emp(emp_id in employees.employee_id%type) is
    begin
        delete from employees where employee_id=emp_id;
    end;
    
-- Question 6
create or replace
procedure find_emp is
    begin
        for tmp in 
            (SELECT emp.*
            FROM employees emp, jobs jb
            WHERE ((emp.salary > jb.min_salary) and (emp.salary < jb.max_salary) and (emp.job_id = jb.job_id)))
            
            LOOP
                dbms_output.put_line(tmp.employee_id || ' - ' || tmp.salary);
            END LOOP;
    end;
    
-- Question 7
create or replace
procedure update_comm is
    begin
        update employees 
        set employees.salary = case
            when add_months(hire_date, 24) < to_date(trunc(sysdate)) then salary + 200
            
			when add_months(hire_date, 12) < to_date(trunc(sysdate))
				and add_months(hire_date, 24) > to_date(trunc(sysdate)) then salary + 100
                
			when add_months(hire_date, 12) = to_date(trunc(sysdate)) then salary + 50
            
			else salary
            
            end;
    end;
    
-- every salary will plus 200


-- Question 8
create or replace
procedure job_his(emp_id in employees.employee_id%type, j_his out job_history%rowtype) is
    begin
        select * into j_his
        from job_history jh
        where jh.employee_id=emp_id;
    end;
    
-------------------------------------------------------


-- Bai 2

-- Question 1
create or replace
function sum_salary(dept_id in departments.department_id%type)
return employees.salary%type
is
all_salary employees.salary%type;
    begin
        select sum(employees.salary) into all_salary
        from employees
        where employees.department_id=dept_id;
        
        return all_salary;
    end;
    
-- Question 2
create or replace
function name_con(coun_id in countries.country_id%type)
return countries.country_name%type
is
c_name countries.country_name%type;
    begin
        select countries.country_name into c_name
        from countries
        where countries.country_id=coun_id;
        
        return c_name;
    end;
    
-- Question 3
create or replace
function annual_comp(s in employees.salary%type, cpct in employees.commission_pct%type)
return employees.salary%type
is
year_salary employees.salary%type;
    begin
        year_salary := s*12 + (cpct*s*12);
        
        return year_salary;
    end;
    
-- Question 4
create or replace
function avg_salary(dept_id in departments.department_id%type)
return employees.salary%type
is
avg_sal employees.salary%type;
    begin
        select avg(employees.salary) into avg_sal
        from employees e, departments d
        where d.department_id=e.department_id and d.department_id=dept_id;
        
        return avg_sal;
    end;
    
-- Question 5

-- To debug a function go to Functions in the UI of Sql developer
-- Find your function in the package Functions
-- A file for debug will be opened, click the bug to debug

-- Before debug, grant acces for the user(ex: hr) by using another user(ex: sys as sysdba)
-- GRANT DEBUG ANY PROCEDURE TO database_name;
-- GRANT DEBUG CONNECT SESSION TO database_name;
-- GRANT EXECUTE ON SYS.DBMS_DEBUG_JDWP to database_name;

-- If still cannot debug, then download sql developer > 20.2
-- Go to tools -> preferences -> debugger -> tick the box 'use DBMS_DEBUG' 
create or replace
function time_work(emp_id in employees.employee_id%type)
return number
is
month_work number;
        cur_date date;
        start_date date;
        tmp number;
    begin       
        select to_date(trunc(sysdate), 'dd-mm-yyyy') into cur_date from dual;
        select to_date(employees.hire_date, 'dd-mm-yyyy') into start_date
        from employees
        where employee_id = emp_id;

--        minus date will result days differece
        select floor((cur_date - start_date)/30) into month_work from dual;

        return month_work;
    end;

declare
    month_work number;
begin
    month_work := time_work(110);
    DBMS_OUTPUT.put_line(month_work);
end;

------------------------------------------------------------

-- Bai 3

-- Questoin 1
create or replace 
trigger trigger_insert_update_employees
    before insert or update on employees
    for each row
begin
  if sysdate < :new.hire_date then
    raise_application_error(-20001, 'Hire date must be before today or today');
  end if;
end;

-- Question 2
create or replace 
trigger trigger_insert_update_jobs
  before insert or update on jobs
  for each row
begin
  if :new.min_salary >= :new.max_salary then
    raise_application_error(-20001, 'Min salary must be less than max salary');
  end if;
end;

-- Question 3
create or replace 
trigger trigger_insert_update_job_history
  before insert or update on job_history
  for each row
begin
  if :new.end_date < :new.start_date then
    raise_application_error(-20001, 'Start date must be less than or equal end date');
  end if;
end;

-- Question 4
create or replace 
trigger trigger_update_employees_2
  before update on employees
  for each row
begin
  if :new.salary <= :old.salary or :new.commission_pct <= :old.commission_pct then
     raise_application_error(-20001, 'Salary and commission must be more than recent salary and commision');
  end if;
end;
