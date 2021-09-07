const quizData= [ 
	{
	  question: 'O que é um Scanner?',
	  a: 'Uma variável para declarar um texto.',
	  b: 'São para imprimir algo na tela, delimitam padrões que correspondem aso espaços em branco, tabulações e mudança de linha.',
	  c: 'Para fazer um laço no código.',
	  d: 'Usado para anexar documentos no programa.',
	  correct: 'b',
	},
	{
	  question: ' Como como importar o Scanner?',
	  a: 'Com "import java.util.Scanner;".',
	  b: 'Só escrever "Scanner" abaixo do "main".',
	  c: 'Começar o código com um texto.',
	  d: 'Com "import java.util.InputMismatchException;".',
	  correct: 'a',
	},
	{
	  question: 'Como fechar scanner no Java?',
	  a: 'Usando "Default".',
	  b: 'Só com um "{}"',
	  c: 'Com um "return;".',
	  d: 'Com o método "close()".',
	  correct: 'd',
	},{
	  question: ' Asinale a alternativa incorreta:',
	  a: 'import java.util.Scanner; Scanner scanner = new Scanner(System.in);',
	  b: 'import java.util.Scanner; Scanner Leitor = new Scanner(System.in);',
	  c: 'import java.util.scanner; Scanner scanner = new Scanner(System.in);',
	  d: 'import java.util.Scanner; Leitor scanner = new Scanner(System.in);90',
	  correct: 'c',
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
	//check to see the answer
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
		  <h2>You have answered correctly at ${score}/${quizData.length} questions. </h2>
		  <button onclick="location.reload()">Reload</button>`;
	   }
	}
  });
  