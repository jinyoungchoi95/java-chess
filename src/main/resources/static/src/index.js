let gameStatus = "";

async function setUpIndex() {
    await displayBoard();
    const tweetDiv = document.createElement('div');
    document.body.append(tweetDiv);
}

async function displayBoard() {
    Array.from(await getBoard()).forEach(
        function(element) {
            const imgTeg = document.createElement("img");
            const imgPath = `images/${element.color}_${element.name}.png`;

            imgTeg.setAttribute("src", imgPath);
            document.getElementById(element.position).appendChild(imgTeg);
        }
    )
}

async function getBoard() {
    return await fetch("/board")
        .then((response) => response.json());
}

async function startChessGame() {
    await fetch("/start", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    });
}