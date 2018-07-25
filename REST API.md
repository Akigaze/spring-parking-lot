# Parking Lot API
---
## 1-新增停车场
```javascript
method: Post
url: /parkinglots
request: {
    newLot:ParkingLot
}
response: {
    newLot
}
```
## 2-新增停车小弟
```javascript
method: Post
url: /parkingboys
request: {
    newBoy:ParkingBoy
}
response: {
    newBoy
}
```
## 3-为停车小弟添加管理的停车场
```javascript
method: Post
url: /parkingboys/{boyID}/parkinglots
request: {
    ParkingLot
}
response: { }
```
## 4-查询所有停车场的信息
```javascript
method: Get
url: /parkinglots
request: { }
response: {
    List<ParkingLot>
}
```
## 5-查询所有停车小弟的信息
```javascript
method: Get
url: /parkingboys
request: { }
response: {
    List<ParkingBoy>
}
```
## 6-按ID查询停车场的信息
```javascript
method: Get
url: /parkinglots/{id}
request: { }
response: {
    ParkingLot
}
```
## 7-按ID查询停车小弟的信息
```javascript
method: Get
url: /parkingboys/{id}
request: { }
response: {
    ParkingBoy
}
```
