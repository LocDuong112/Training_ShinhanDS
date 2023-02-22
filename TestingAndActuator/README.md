# Testing, Actuator and devtools

## Part 1: Testing

![](./Image/Testing/result_all-test-passes.png)

## Part 2: Actuator and devtools

### Actuator

* Management port: 8090
* Open all endpoints, including shutdown endpoint
* Doing following requirements:
  * Use specific actuator url to watch all endpoints
  * Use specific actuator url to watch the app's health status
  * Use specific actuator url to shut down the app

#### Answer

![](./Image/Testing/actuator-setup.png)

#### Result

![](./Image/Testing/use-actuator-to-see-endpoints-of-the-app.png)

![](./Image/Testing/use-actuator-to-check-health.png)

![](./Image/Testing/actuator-shutdown.png)


### DevTools

* During runtime, change management port of actuator to 8091
  * Use specific actuator url with new management port to watch all endpoints

#### Answer

![](./Image/Testing/import-devtools.png)

#### Result

Just add devtools dependency, and it will do the thing

![](./Image/Testing/devtools-active.png)

![](./Image/Testing/change-port-with-devtool.png)

![](./Image/Testing/devtool-automatically-restart-when-making-changes-in-properties.png)
