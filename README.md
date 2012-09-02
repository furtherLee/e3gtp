EEE GTP ENGINE (e3gtp)
=======================
In AI course, we are required to design and implement an agent to play `GO` with each other. In the stage of preparation, we are suggested to use a mature GTP engine in C implementation. However, I'm eggache. I started to search whether there is a java version. Finally, I was frustrated that, such a thing I have ever found is not Open Source! So I decided to implement one ^ ^.

What is EEE
-----------
Well, it is not another abbreviation for IEEE, it is just EEE. When ACMers are happy, or don't know what to say, they always shout "E E E!". In Chinese, it may means "Goose, Goose, Goose". That's all.

What is GTP
------------
[**GTP**](http://www.lysator.liu.se/~gunnar/gtp/), or *Go Text Protocol* is a protocol for communicating between two agents who are playing computer go. Go is a traditional Chinese Game, which brings great challenges in AI area. The version I implemented is [GTP 2, draft 2](http://www.lysator.liu.se/~gunnar/gtp/gtp2-spec-draft2/gtp2-spec.html), which is required by my AI course.

Architecture
-------------
The whole project is built by ant(Well, I'm trying to use maven). 

    ---------------------------
    |Agent Algorithm (Visitor)|
    ---------------------------
              | |
              | |
    ---------------------------
    |        Command          |
    ---------------------------
              | |
              | |
    ---------------------------
    |       Connection        |
    ---------------------------

Connection is responsible to set up a stream for communication. An agent will continuely read command in a connection. After something is received, an agent should use *Command Factory* to parse it, and generate a command. A command take some parameters, and should be handled with a *Command Visitor*.

By the way, I implement all gtp types in package e3gtp.connection. I use `Visitor Pattern` here, since every agent algorithm is a visitor of commands. Therefore, the agent should keep state machine of itself. After visit a command, a command visitor should generate a `Response`. A response includes an ID(optional), whether succeed, and the response body according to the protocol.

License: [DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE](http://sam.zoy.org/wtfpl/COPYING)

Author: [Li Shijian](http://github.com/furtherLee)

