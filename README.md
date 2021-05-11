# NotificationCentral
CS 371 group project

Project Description: The goal of this project is to create a desktop notification center UI that is 
capable of handling multiple notifications from a variety of apps. The UI will be minimal in design 
and should be capable of showing all notifications at once.

This project will consist of a notification computer app that can organize all of your notifications 
into one central place. Instead of getting annoying individual notifications for every little thing, 
our app will condense and organize those notifications down into simple tiles that can be expanded to 
read more about your notifications. That way, when you go to check your notifications for the day and 
catch up on what you missed, you can simply open this app and see everything all at once. And while you 
are away, it will tell you if you have a lot of messages building up on a couple of apps, or if something 
you marked as important needs your attention, so that you never forget to keep up with your email, 
messages, assignments, and more.

Current design uses javafx to build notification window with 5 buttons that when clicked, show the current 
notification.And when clicked again, shrink back to the original size. The window sits at the left side of 
screen and will float at top layer of screen, meaning a user can always have access to their current 
notifications. The window will be slightly transperent, so that the user can still see most of their work 
space while the notification central window is open.


The structure for this project:
ReadInCSV -- this code reads in 5 csv files with stock notifications. This code has no main method, but has 
a getNotification(fileName) method
NotificationButton -- this code uses a contructor to pass info to buttons: what icons they have, their 
dimensions, what happens when I click it. It uses object oriented programming to make generic code for 
building each button. The "click on action" method reads a notification from the button's csv file and keeps 
canvas seperate from discord.
MakeApplication -- this code builds the stage adn window for the notification central window. Thi is also 
where the scroll bar and transparency is declared. This builds 5 buttons and uses the cinstructor from 
NotificationCentral.
To use this code, you need 5 icons sotried in the same folder as this ccode. You also need 5 csv files with 
notifications seperated by commas, see current code for examles. Additionally, you need a photo as the 
background for the window. 


Link to project pages: https://n3rdgirl-365.github.io/


Code Resources:
