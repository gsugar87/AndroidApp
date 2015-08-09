# AndroidApp

This app eventually will be used for home automation.

Desired Functionality:

1. Connect to raspberry pi via ssh when launched.

2. Read the current state of the system:

  a) Current Temperature

  b) Set Temperature Range

  c) Outlets on/off status

3. Create buttons with correct labels (Turn On/Off)

4. Display current temperature reading.

How to implement:
Currently it works via twitter.  I'd like to have a status file that the raspberry pi edits (outlets on/off,
current temperature, desired temperature range), and a setting file that the android edits (desired outlet 
on/off, desired temperature range).  The android will edit the setting file via ssh, and the raspberry pi will
check for changes in the file every x seconds.  When there is a change in the file, the raspberry pi will do 
perform the appropriate action, and change the status file appropriately.  The raspberry pi will also edit the
status file every x minutes so that the android app reading it will be up to date.
