# EcoSystem Description
EcoRe is a company that wants to design and manufacture an EcoRecycle System, consisting of
Recycling machines and Recycling stations which monitor the recycling machines.
The project is to help EcoRe design and implement the Recycling machines and Recycling Stations. 
Given below is the description of the functionality of the different components in this system.

### A Recycling machine (RCM) is designed to accept recyclable items where a user is paid a small 
amount of money (or a coupon that can be redeemed at local stores) for each type of item. 
The recycling machine is equipped with an interface to display the items accepted by the machine, 
the amount paid for each item and slots to accept the items and return the money to the user. 
Each Recycling Machine has a machine id, location, a list of items that it can accept, price paid 
for each item, capacity (in weight), total weight of items currently in the machine, last time 
the machine is emptied of items.

### A Recycling Monitoring Station (RMOS) is a software program that runs on a workstation that 
is connected to monitor different recycling machines within a radius of one mile. It is used to 
activate each recycling machine in the group (it monitors) to accept items and keep track of the 
status of each individual recycling machine.

The RMOS monitors a group of RCMs (in my demo, there are firstly 2 RCMs in the group before adding a new RCM). 
The RMOS GUI interface provides the following functionality:
(1) Login: Firstly, the administrator logs in with a username and password. (Username = admin, Password = 1234)​
(2) Show all monitored RCMs
(3) Add new RCMs
(4) Check RCM’s operational status/Activate RCM
(5) Change/add new types of recyclable items
(6) Check the amount of money: You can check the money in each machine.
(7) Check the current capacity(by weight)
(8) Empty full RCM
(9) Check last emptied time
(10) Display the usage statistics for each RCM in the RCM group
