var seatList = document.getElementById("seatList")
var seat = ""
var seatName = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']
var chooseSeats = []

for(i of seatName) {
  seat += "<div class='d-flex flex-row justify-content-center align-items-center w-100' >"
  for(j = 1; j <=8; j++) {
    seat += `<button class='btn btn-secondary' id="${i+j}" onclick="addSeat('${i+j}')" style='width: 20%'>${i+j}</button>`
  }
  seat += "</div>"

} 

seatList.innerHTML = seat

var seats = document.getElementById("seats")

function addSeat(name) {
  var choosed = document.getElementById(name)
  if(chooseSeats.indexOf(name) == -1) {
    choosed.classList.replace("btn-secondary", "btn-primary")
    chooseSeats.push(name)
  } else {
    choosed.classList.replace("btn-primary", "btn-secondary")
    chooseSeats = chooseSeats.filter(x => x != name)
  }

  var values = chooseSeats.join(", ")
  seats.value = values 
}  