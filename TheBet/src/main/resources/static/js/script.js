window.addEventListener('load', function(e) {
	console.log('script.js loaded')
	init();
});

function init() {
	console.log('In init');
	document.betForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		var betId = document.betForm.betId.value;
		if(!isNaN(betId) && betId > 0) {
			getBet(betId);
		}
	})
}

function getBet(betId) {
	console.log('getBet(): betId is ' + betId);
	let xhr = new XMLHttpRequest();
	console.log('xhr.readyState = ' + xhr.readyState);
	xhr.open('GET', 'api/bets/' + betId);
	console.log('xhr.readyState = ' + xhr.readyState);
	xhr.onreadystatechange = function() {
		console.log('xhr.readyState = ' + xhr.readyState);
		
		if(xhr.readyState === 4) {
			if(xhr.status === 200) {
				let bet = JSON.parse(xhr.responseText);
				console.log(bet);
				displayBet(bet);
			}
			else {
				//if request failed or no response text, put "bet not found"
			}
		}
	}		
	console.log('Before send: xhr.readyState = ' + xhr.readyState);
	xhr.send();
	console.log('After send: xhr.readyState = ' + xhr.readyState);
}

function displayBet(bet) {
	var betDiv = document.getElementById('betData');
	betDiv.textContent = '';
	let h1 = document.createElement('h1');
	h1.textContent = bet.name;
	betDiv.appendChild(h1);
	
	let bq = document.createElement('blockquote')
	bq.textContent = bet.wager;
	betDiv.appendChild(bq);
	
	let ul = document.createElement('ul');
	betDiv.appendChild(ul);
	
	let li = document.createElement('li');
	li.textContent = bet.wagerDate;
	betDiv.appendChild(li);
	
	li = document.createElement('li');
	li.textContent = bet.deadlineDate;
	betDiv.appendChild(li);

	li = document.createElement('li');
	li.textContent = bet.bettor.name;
	betDiv.appendChild(li);

	li = document.createElement('li');
	li.textContent = bet.bettee.name;
	betDiv.appendChild(li);
	
	
	
	// need to find a way to add bettor and bettee here. I'm not sure 
	// if bet.bettee.name would work
	
}