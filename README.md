# Secret Password

A Minecraft Fabric Server mod to require entry of a shared server password to join

## Why

If you want to allow people to join your server without Mojang verification, but still want to protect against unauthorized entry, you can set a server-level password for all users in the server and share it with only people you trust.

## How (WIP)

Configure your password with the following commands (requires OP permissions):

`/setpassword <newpassword> <newpassword>`

`/changepassword <oldpassword> <newpassword> <newpassword>`

`/clearpassword <password>`

`/enablepassword <password>`

`/disablepassword <password>`

Users on login will be prompted to provide the password via `/login <password>`

## Credits

[Jacie ZYT's More Powerful Password System For Fabric Servers](https://github.com/Jasonzyt/password-fabric)
