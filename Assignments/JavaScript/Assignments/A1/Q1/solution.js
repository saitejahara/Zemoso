let function1 = function ()
{
    let var1="Inside function 1"
    //console.log(var1);
    return var1; 
}


function function2()
{
    let var2="Inside functon 2"
    //console.log(var2);
    return function1()+" "+var2;
}


console.log(function2());