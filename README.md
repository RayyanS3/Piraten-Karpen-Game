# A1 - Piraten Karpen

- Author: Rayyan Suhail
- Email: <suhailr@mcmaster.ca>

## Build and Execution

- To clean your working directory:
  - `mvn clean`
- To compile the project:
  - `mvn compile`
- To run the project in development mode:
  - `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
- To package the project as a turn-key artefact:
  - `mvn package`
- To run the packaged delivery:
  - `java -jar target/piraten-karpen-jar-with-dependencies.jar`
- To actiavte trace mode:
  - Type yes into the promt given at the start of execution of the  program
- To select the player stratergy: 
  - Type random or combo into the first two command line arguments corresponding to the first and second player
    i.e. if you want player 1 combo and player 2 random use:
  - `java -jar target/piraten-karpen-jar-with-dependencies.jar combo random`

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

- Status:
  - Pending (P), Started (S), Blocked (B), Done (D)
- Definition of Done (DoD):
  - Precisely meets the needs of the client whislt being as best as possible in time and memory complexity. Also passes multiple test cases to ensure quality.

### Backlog

|  MVP? | Id  | Feature                                          | Status  | Started  | Delivered |
| :---: | :-: | -------------------------------------------------| :-----: | :------: | :-------: |
|  Yes  | F01 | Roll a dice                                      |    D    | 01/01/23 | 01/17/23  |
|  Yes  | F02 | Roll eight dices                                 |    D    | 01/17/23 | 01/17/23  |
|  Yes  | F03 | Play a total of 42 games                         |    D    | 01/17/23 | 01/17/23  |
|  Yes  | F04 | end of game with three skulls                    |    D    | 01/17/23 | 01/18/23  |
|  Yes  | F05 | Player keeping random dice at their turn         |    D    | 01/18/23 | 01/19/23  |
|  Yes  | F06 | Score points: 100 points for each gold/diamond   |    D    | 01/18/23 | 01/18/23  |
|  Yes  | F07 | Loggers activated when trace mode is used        |    D    | 01/23/23 | 01/23/23  |
|  Yes  | F08 | Command line arguments used to make combo/random |    D    | 01/23/23 | 01/24/23  |
|  Yes  | F09 | Implementing sea cards and 'nop' cards           |    D    | 01/24/23 | 01/25/23  |
|  Yes  | F10 | Making card deck and adding the set of cards     |    D    | 01/25/23 | 01/25/23  |
|  Yes  | F11 | Implementing Monkey cards                        |    D    | 01/25/23 | 01/26/23  |
