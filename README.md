Turing Machines 
---------------------------------

A Turing Machine is a theortical machine of infinte memory. Invented by Alan Turing in 1936. 
The main parts of a Turing Machine is a controller, a tape and a head. The machine changes its states and write on tape by following  transition rules. 
To create a new Turing Machine:



1. Create a Transitions array:
Transition[] ts = new Transition[size];  
where the size = no of states * no alphabet, each transition is in the form of (State , symbol on tape) ===> (Next state , write symbol on tape, head direction). 
2. Create a new controller: 
 Controller TM = new Controller (ts,start_state,lalphabet); 
where laplhabet is the length of alphabet and start_state is the intial state of Turing Machine 
3. Call ExecuteOverInput(input): 
where input is the contents intially on the tape, the output should be as the following:
TAPE: aaa	 Current State: 0
TAPE: aaa	 Current State: 0
TAPE: aaa	 Current State: 0
aaa
