# Aryak's CLI

###### An installable CLI application comprising simple Linux & Redis mock commands created using spring boot shell.

### Commands available :
- ping
- date
- cp
- lpush
- rpop
- show
- llen

### Installing the CLI on your machine

- Java 21 installation is a prerequisite. Run the bash script available
```console
./install-cli.sh
```
### GLOSSARY OF COMMANDS

- ping, mandatory health check :)
```console
aryak's-cli:> ping
pong!
```

- date (current date time)
```console
aryak's-cli:> date
Wed Jan 01 14:11:06 IST 2025
```

- cp (copy file from path 1 to path 2)
```console
aryak's-cli:> cp 
Missing mandatory option '--path2'
Missing mandatory option '--path1'
```
```console
aryak's-cli:> cp "/Users/aryak/Desktop/Unix 2/Hotel.txt" "/Users/aryak/Desktop"
```

- LPUSH (append an elements to the left of a list)
```console
aryak's-cli:> lpush products eggs
1
aryak's-cli:> lpush products milk
2
```

- SHOW (display entire list)
```console
aryak's-cli:> show products
[milk, eggs]
```

- RPOP (removes an elements from the right of a list)
```console
aryak's-cli:> rpop products
1
```

- SHOW
```console
aryak's-cli:> show products
[milk]
```
- LLEN (displays number of elements present in the given list)
```console
aryak's-cli:> llen products
1
```

### Build
- Apache Maven used to build the project
- As simple as running :
```console
aryak@Aryaks-MacBook-Pro Desktop % mvn clean install -DskipTests=true
```