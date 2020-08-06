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
(2) Show all monitored RCMs: In the graphical interface of RMOS, each RCM monitored by this workstation is 
represented with its machine number, location and an id as a list.
(3) Add new RCMs: ​You can add a new machine to the RMOS by clicking the “A dd a new RCM”
button, and the list will be refreshed.
(4) Check RCM’s operational status/Activate RCM:You can check the operational status 
of each machine by inputting machine number and clicking the “Check Status” button. 
When the machine’s status is down, you cannot open the machine. After clicking the “Activate Machine” button, 
the machine’s status becomes operational, you activate the recycling station in the group to accept items.
(5) Change/add new types of recyclable items: You can add new types of recyclable items in the field of <Add New Item Type>. 
By inputting the item type you want to change and the new item type, you can change types of recycle items.
(6) Check the amount of money: You can check the money in each machine.
(7) Check the current capacity(by weight): You can check the available capacity (by weight-lb)
in each machine by inputting machine number and clicking the “Check Current Capacity” button. 
If there is no more capacity, you will get a message that the machine is full and needs to be emptied.
(8) Empty full RCM: By inputting machine number and clicking the “Empty the machine” button, 
you can empty a machine which has no available capacity, and the machine will store the time of the last removal of its items. 
If the machine is not full, you will get an error message and cannot empty it.
(9) Check last emptied time: You can check the last emptied time of each machine by inputting machine number and clicking 
the “Check Last Emptied Time” button.
(10) Display the usage statistics for each RCM in the RCM group: Display the usage statistics with text and visual graph 
for each machine by inputting the machine number and clicking the “Show Usage Statistics” button. 
Usage statistics includes: weight of items collected in a month, total value (cash or coupons) issued in a month, 
no. of items returned by machine in a month and the no. of times the machine was emptied in a month.

