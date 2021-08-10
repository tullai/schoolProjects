Reliable Transfer Protocol (RTP) 
Computer Networks Assignment
---------------------------

Group Members:
GROUP 1
1. Tulaib Ahmed- 2018A7PS0272H
2. Ritika Reddy- 2018A7PS1224H
3. Anvitha Nallan- 2018A7PS1214H
4. Waquar Wasif- 2018A7PS0254H
5. Navdeep Singh- 2017B5A71675H
6. Abhishek Mishra- 2018A7PS0019H

GROUP 2
1. Anurag Aribandi: 2018A7PS1218H
2. Varun Narayanan: 2018A7PS1226H
3. Himnish Kapoor: 2018A7PS1215H
4. Anish Mitta: 2018A7PS1221H
---------------------------

I. File list
rtp_c.cpp - RTP Client Side Implementation
rtp_d.cpp - RTP Server Side Implementation
rtp.h - Utility library for the above two programs
c1.txt - Sample file which we would PUT/GET to/from server

--------------

II. Build
Run 'make'

--------------

III. Command Line Arguments to Run
Run RTP Server
$./rtp_s

Run RTP Client
$./rtp_c GET/PUT server_address file_name

GET = to fetch file_name from server_address
$./rtp_c GET 127.0.0.0 c1.txt
PUT = to send file_name to server_address
$./rtp_c PUT 127.0.0.0 c1.txt

--------------

IV. Details of Code

A. General
General Configuration of the program can be changed from rtp.h
TIME_OUT: It means for how much time host should wait for ACK and after that it will again send the previous packet
MAX_TRIES: These are the maximum number of tries a host will try to send the packet to other host(client/server)
MYPORT: It is the port number of the server

B. RTP server
This code has been implemented in file rtp_s.cpp

1. Configuration

2. RSEN(Read Request)

3. RREC(Write Request)


C. RTP client
This code has been implemented in file rtp_c.cpp

1. Configuration
After socket has been opened on server side on port 4950, then client sends RRQ or WRQ to the server accordingly. And then waits for the acknowledgement from server.

2. RSEN(Read Request)
Format of new file made is : name_of_file_received_client

3. RREC(Write Request)
Format of new file made is : name_of_file_sent_server

--------------

V. Changes made in protocol

Due to unexpected complexity faced during implementation, we removed some features from our original protocol. The features removed are:
1. Delete (DEL) 
2. Store (STR)
3. NACK

*Minor changes were made in packet structure.



