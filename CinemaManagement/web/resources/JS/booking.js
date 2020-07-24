//var seatList = document.getElementById("seatList")
//var seat = ""
//var count = 0
//
//for (key in tickets) {
//    console.log(key)
//    var ticket = tickets[key]
//
//    if (count == 0) {
//        seat += "<div class='d-flex flex-row justify-content-center align-items-center w-100' >"
//    }
//
//    if (ticket["status"] == 1) {
//        seat += `<button class="btn btn-warning" id="${ticket['tId']}" disabled style='width: 20%'>${key}</button>`
//    } else {
//        seat += `<button class='btn btn-secondary' id="${ticket['tId']}" onclick="addSeat('${key}', ${ticket['tId']})" style='width: 20%'>${key}</button>`
//    }
//
//    count += 1
//    if (count == 8) {
//        seat += "</div>"
//        count = 0
//    }
//}
//
//seatList.innerHTML = seat
//
//var seats = document.getElementById("seats")
//var ticketId = document.getElementById("ticketIds")
//
//var chooseSeats = []
//var ticketIds = []
//
//function addSeat(name, tId) {
//    var choosed = document.getElementById(tId)
//    if (chooseSeats.indexOf(name) == -1) {
//        choosed.classList.replace("btn-secondary", "btn-white")
//        chooseSeats.push(name)
//        ticketIds.push(tId)
//    } else {
//        choosed.classList.replace("btn-white", "btn-secondary")
//        chooseSeats = chooseSeats.filter(x => x != name)
//        ticketIds = ticketIds.filter(x => x != tId)
//    }
//
//    var values = chooseSeats.join(", ")
//    seats.value = values
//    ticketId.value = ticketIds.join(", ")
//}
//
//function billForm() {
//    location.href = `bill.html?rId=${rId}&tickets=${ticketIds.join(", ")}&ticketNames=${chooseSeats.join(", ")}`
//}