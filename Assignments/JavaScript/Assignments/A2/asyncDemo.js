// function getData(uId) {
//     setTimeout(() => {
//     console.log("Fetched the data!");
//     return "skc@gmail.com";
//     }, 4000);
//     }
    
//     console.log("start");
//     var email = getData("skc");
//     console.log("Email id of the user id is: " + email);
//     console.log("end");





function getData(uId) {
    return new Promise((resolve, reject) => {
        console.log("Fetching data..");
      setTimeout(() => {
        let fetch=true;
        if(fetch){
            console.log("Fetched the data!");
            resolve("skc@gmail.com");
        }
        else{
            reject("Error fetching the data");
        }    
    }, 4000);
    });
  }

  async function main() {
    getData("skc").then(function(message){
        console.log("Email id of the user id is: " + message);
    }).catch(function(reason){
        console.log("Didn't get response: " +reason)
    })    
  }

  main();