# Ethical Phishing

**Disclaimer: This program is not malicious in any way, shape, or form***

## Background

This repository is aiming to educate my friends and family about phishing attempts.

I recently received an email from "Apple Support" claiming my account needed attention. 
However, this was **not** the case. This email was a phishing attempt to get my Apple log
in information. This got me thinking; I wonder if my family and friends click random stuff? Have they been 
breached without even realizing it?

## What the Program Does

1. Posts to a JSON payload to a Firebase Realtime-Database
    - The operating system
    - The user's sign-in name
    - Timestamp
1. Popup a display dialog explaining what just happened (informing the user)
1. Play "Star Wars: A New Hope" in the native terminal

## The End Goal

The main goal of this exercise is to educate people in a fun way. I believe that, 
sometimes, people have to fall victim to a phishing attempt before knowing what to 
look for.

The lesson to be learned from this exercise: **Do not open attachments or click links from people you do not know**

## Phishing Attempt

1. Create a gmail account with a generic support-looking email
1. Send an email stating the recipient won a free cruise and must open the file to claim their winnings
    - Attach zipped-up `.jar` file
