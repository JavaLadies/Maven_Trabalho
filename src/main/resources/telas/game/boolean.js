function handleClick() {
    var amountCorrect = 0;
    for (var i = 1; i <= 45; i++) {
        var radios = document.getElementsByName('quiz' + i);
        for (var j = 0; j < radios.length; j++) {
            var radio = radios[j];
            if (radio.value == "correct" && radio.checked) {
                amountCorrect++;
            }
        }
    }
    submitBtn.addEventListener('click', () => {
        const answer = getSelected();

        if (answer) {
            if (answer === quizData[currentQuiz].correct) {
                score++;
            }

            currentQuiz++;
            if (currentQuiz < quizData.length) {
                loadQuiz();
            } else {
                quiz.innerHTML = `
              <h2>você acertou: ${score}/${quizData.length} questões. </h2>
              <button onclick="location.reload()">Ne</button>`;
            }
        }
    });
}