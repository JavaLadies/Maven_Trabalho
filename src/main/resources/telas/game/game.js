const quizData = [
    {
      question: "how old is everything?",
      a: "10",
      b: "20",
      c: "30",
      d: "40",
      correct: "b"
    },
    {
      question: "whats the most used programming?",
      a: "java",
      b: "C",
      c: "python",
      d: "JavaScript",
      correct: "a"
    },
    {
      question: "whos the president of US?",
      a: "trump",
      b: "Obama",
      c: "tongo",
      d: "Biden",
      correct: "d"
    },
    {
      question: "what does html stands for?",
      a: "hypertext markup language",
      b: "hype mom laughin",
      c: "jason object notation",
      d: "Application programming interface",
      correct: "a"
    },
    {
      question: "what year was javascript launch?",
      a: "2010",
      b: "2020",
      c: "1995",
      d: "1090",
      correct: "c"
    }
  ];
  
  const quiz = document.getElementById("quiz");
  const answerEls = document.querySelectorAll(".answer");
  const questionEl = document.getElementById("question");
  const a_text = document.getElementById("a_text");
  const b_text = document.getElementById("b_text");
  const c_text = document.getElementById("c_text");
  const d_text = document.getElementById("d_text");
  const submitBtn = document.getElementById("submit");
  
  let currentQuiz = 0;
  let score = 0;
  
  loadQuiz();
  
  function loadQuiz() {
    deselectAnswers();
  
    const currentQuizData = quizData[currentQuiz];
  
    questionEl.innerText = currentQuizData.question;
    a_text.innerText = currentQuizData.a;
    b_text.innerText = currentQuizData.b;
    c_text.innerText = currentQuizData.c;
    d_text.innerText = currentQuizData.d;
  }
  
  function getSelected() {
    let answer = undefined;
  
    answerEls.forEach((answerEl) => {
      if (answerEl.checked) {
        answer = answerEl.id;
      }
    });
    return answer;
  }
  
  function deselectAnswers() {
    answerEls.forEach((answerEl) => {
      answerEl.checked = false;
    });
  }
  
  submitBtn.addEventListener("click", () => {
    //check to see the answer
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
          <h2>You have answered correctly at ${score}/${quizData.length} questions. </h2>
          <button onclick="location.reload()">Reload</button>
          `;
      }
    }
  });
  