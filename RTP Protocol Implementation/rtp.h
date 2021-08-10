/**
 * rtp.h - header file which contains common function of rtp_c.c and rtp_s.c

 Group 1
 Waquar Wasif: 2018A7PS0254H
 Tulaib Ahmed Abdullah: 2018A7PS0272H
 Ritika Reddy: 2018A7PS1224H
 Anvitha Nallan: 2018A7PS1214H
 Abhishek Mishra: 2018A7PS0019H
 Navdeep Singh : 2017B5A71675H

 Group 2
 Anurag Aribandi: 2018A7PS1218H
 Varun Narayanan: 2018A7PS1226H
 Himnish Kapoor: 2018A7PS1215H
 Anish Mitta: 2018A7PS1221H
 */
 
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MYPORT "4950"				 // port to be opened on server
#define SERVERPORT "4950"		 // the port users will be connecting to
#define MAXBUFLEN 550				 // get sockaddr, IPv4 or IPv6:
#define MAX_READ_LEN 512		 // maximum data size that can be sent on one packet
#define MAX_FILENAME_LEN 100 // maximum length of file name supported
#define MAX_PACKETS 99			 // maximum number of file packets
#define MAX_TRIES 3					 // maximum number of tries if packet times out
#define TIME_OUT 5					 // in seconds

// converts block number to length-2 string
void s_to_i(char *f, int n)
{
	if (n == 0)
	{
		f[0] = '0', f[1] = '0', f[2] = '\0';
	}
	else if (n % 10 > 0 && n / 10 == 0)
	{
		char c = n + '0';
		f[0] = '0', f[1] = c, f[2] = '\0';
	}
	else if (n % 100 > 0 && n / 100 == 0)
	{
		char c2 = (n % 10) + '0';
		char c1 = (n / 10) + '0';
		f[0] = c1, f[1] = c2, f[2] = '\0';
	}
	else
	{
		f[0] = '9', f[1] = '9', f[2] = '\0';
	}
}

// makes RSEN packet
char *make_rsen(char *filename)
{
	char *packet;
	packet = (char *)malloc(2 + strlen(filename));
	memset(packet, 0, sizeof packet);
	strcat(packet, "01"); //opcode
	strcat(packet, filename);
	return packet;
}

// makes RREC packet
char *make_rrec(char *filename)
{
	char *packet;
	packet = (char *)malloc(2 + strlen(filename));
	memset(packet, 0, sizeof packet);
	strcat(packet, "02"); //opcode
	strcat(packet, filename);
	return packet;
}

// makes data packet
char *make_data_pack(int block, char *data)
{
	char *packet;
	char temp[3];
	s_to_i(temp, block);
	packet = (char *)malloc(4 + strlen(data));
	memset(packet, 0, sizeof packet);
	strcat(packet, "03"); //opcode
	strcat(packet, temp);
	strcat(packet, data);
	return packet;
}

// makes ACK packet
char *make_ack(char *block)
{
	char *packet;
	packet = (char *)malloc(2 + strlen(block));
	memset(packet, 0, sizeof packet);
	strcat(packet, "04"); //opcode
	strcat(packet, block);
	return packet;
}

// makes ERR packet
char *make_err(char *errcode, char *errmsg)
{
	char *packet;
	packet = (char *)malloc(4 + strlen(errmsg));
	memset(packet, 0, sizeof packet);
	strcat(packet, "05"); //opcode
	strcat(packet, errcode);
	strcat(packet, errmsg);
	return packet;
}
