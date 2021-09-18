const quizData= [ 
  {
    question: 'Qual símbolo representa o valor "Diferente" na linguagem de programação Java?',
    a: '==',
    b: '<>',
    c: '!=',
    d: '||',
    correct: 'c',
  },
  {
    question: 'Para que são utilizados os operadores relacionais?',
    a: 'São os operadores utilizados para realizar operações aritméticas.',
    b: 'São os operadores utilizados para comparar valores de dois operadores.',
    c: 'São operadores que permitem criar expressões lógicas maiores a partir da junção de duas ou mais expressões.',
    d: 'São os operadores utilizados para verificar se duas variáveis contêm o mesmo valor e imprime o resultado.',
    correct: 'b',
  },
  {
    
    question: 'O símbolo '<=' é utilizado quando:',
    a: 'Desejamos verificar se uma variável é menor que outra.',
    b: ' Desejamos verificar se uma variável é maior ou igual a outra.',
    c: 'Desejamos verificar se uma variável é maior que outra.',
    d: 'Desejamos verificar se uma variável é menor ou igual a outra.',
    correct: 'd',
  },
  
];

const quiz = document.getElementById("quiz");
const answerEls = document.querySelectorAll(".answer");
const questionEl = document.getElementById("question");
const a_text =  document.getElementById("a_text");
const b_text =  document.getElementById("b_text");
const c_text =  document.getElementById("c_text");
const d_text =  document.getElementById("d_text");
const submitBtn = document.getElementById("submit");

let currentQuiz = 0;
let score = 0;

loadQuiz();

function loadQuiz(){
  deselectAnswers();
  
  const currentQuizData = quizData[currentQuiz];
  
  questionEl.innerText  = currentQuizData.question;
  a_text.innerText = currentQuizData.a;
  b_text.innerText = currentQuizData.b;
  c_text.innerText = currentQuizData.c;
  d_text.innerText = currentQuizData.d;
}

function getSelected(){
  let answer = undefined;
  
  answerEls.forEach((answerEl) => {
    if(answerEl.checked){
        answer = answerEl.id;
    }  
  });
 return answer; 
}

function deselectAnswers(){
  answerEls.forEach((answerEl)=>{
    answerEl.checked = false;
  });
}

submitBtn.addEventListener ('click', () =>{
  const answer = getSelected();
  
  if(answer){
      if(answer === quizData[currentQuiz].correct){
        score++;
      }
    
      currentQuiz++;
      if(currentQuiz < quizData.length){
        loadQuiz();
      }else{
        quiz.innerHTML = `
        <h2>Você acertou ${score}/${quizData.length} questões. </h2>
        <button onclick="location.reload()">Next</button>
        `;
     }
  }
});
