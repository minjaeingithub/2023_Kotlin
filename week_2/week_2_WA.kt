fun main() {
    var arr = Array(101, {false})
    arr[0] = true; arr[1] = false; //prime
    
    for(i in 2..Math.sqrt(10.toDouble()).toInt()){
		if(arr[i] == true){
            continue;
        }
        for(j in i*i..100 step +i){
            arr[j] = true;
        }
    }
    
    // print prime #s
    println("Hi, 2019313561!");
    println("Prime number under 100 is ..");
    for(i in 2 .. 100){
        if(arr[i] == false){
            println(i.toString()+ " is prime number");
        }
    }
}
