# Backend Project - Java Spring (faircorp)

```Shreyas HARINATH - CPS2-M1 (UJM)```

### Main Feature

This project provides multiple useful REST API's that can be used to manage entities such as windows, heaters and rooms in a building.

-----

### Why this app?

The management of the sanitary conditions (COVID-19 pandemic, pollution), user comfort, and energy efficiency, require concurrent management of window openings in the École des Mines buildings. It is necessary to ventilate as much as possible to limit the spread of the cirus and air pollution in general, but as winter approaches it will become important to heat the buildings to ensure user comfort.

------

### Technologies Used

- **Spring** - Powerful library for developing backend in Java
- **GitHub** - Open source distributed version control system
- **IntelliJ** - IDE used to code in Java language

 --------

*Project includes:*
- 2 Different types of users
- 4 Related tables - Building, Room, Window, Heater
- 4 Data Transfer Objects (DTO) - BuildingDto, RoomDto, WindowDto, HeaterDto
- 4 Data Access Objects (DAO) - BuildingDao, RoomDao, HeaterDao, WindowDao

---------

*Credentials of users:*

- ROLE ***ADMIN***
    - username: admin
    - password: password
- Role ***USER***
    - username: user
    - password: password


### This application is deployed on Clever Cloud: [faircorp-shreyasHarinath](https://https://faircorp-shreyasharinath.cleverapps.io/)

-----

### **APIs used:**

#### building-controller (Building Controller)

| HTTP method | URL | Remark |
|--|--|--|
| **GET** | /api/building | returns a list of all buildings|
| **POST** | /api/building | creates a new building |
| **GET** | /api/building/{id} | returns a specific building by id|
| **DELETE** | /api/building/{id} | deletes a building by id|
| **PUT** | /api/building/{id}/switch | inverts building's status (switch/toggle between LOCKED and UNLOCKED)|


#### heater-controller (Heater Controller)

| HTTP method | URL | Remark |
|--|--|--|
| **GET** | /api/heaters | returns a list of all heaters|
| **POST** | /api/heaters | creates a new heater |
| **GET** | /api/heaters/{id} | returns a specific heater by id|
| **DELETE** | /api/heaters/{id} | deletes a heater by id|
| **PUT** | /api/heaters/{id}/switch | inverts heater's status (switch/toggle between ON and OFF)|


#### room-controller (Room Controller)

| HTTP method | URL | Remark |
|--|--|--|
| **GET** | /api/rooms | returns a list of all rooms|
| **POST** | /api/rooms | creates a new room |
| **GET** | /api/rooms/{id} | returns a specific room by id|
| **DELETE** | /api/rooms/{id} | deletes a room by id|
| **PUT** | /api/rooms/{id}/switchHeater | inverts heater's statuses in room (switch/toggle between ON and OFF)|
| **PUT** | /api/rooms/{id}/switchWindow | inverts window's statuses in room (switch/toggle between OPENED and CLOSED)|


#### window-controller (Window Controller)

| HTTP method | URL | Remark |
|--|--|--|
| **GET** | /api/windows | returns list of all windows|
| **POST** | /api/windows | creates a new window |
| **GET** | /api/windows/{id} | returns a specific window by id|
| **DELETE** | /api/windows/{id} | deletes a window by id|
| **PUT** | /api/windows/{id}/switch | inverts window's status (switch/toggle between OPENED and CLOSED)|


#### hello-controller (Hello Controller)

| HTTP method | URL | Remark |
|--|--|--|
| **GET** | /api/hello/{name} | returns a hello message with user's name: "Hello {name}!!"|

The above REST APIs can be tested here: [Swagger](https://faircorp-shreyasharinath.cleverapps.io/swagger-ui/index.html#/)  ***(Requires user with any role)***
