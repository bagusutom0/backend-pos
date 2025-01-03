let user = {
  name: 'user',
  username: 'usename',
  password: 'password',
  ROLE: 'USER',
};

let counter = 0;
let questions = [
  'Enter your name: ',
  'Enter your username: ',
  'Enter your password: ',
];

process.stdout.write(questions[counter]);
process.stdin.on('data', (data) => {
  let input = data.toString().trim();

  if (counter === 0) {
    user.name = input;
  } else if (counter === 1) {
    user.username = input;
  } else if (counter === 2) {
    user.password = input;
  }

  counter++;

  if (counter < questions.length) {
    process.stdout.write(questions[counter]);
  } else {
    process.stdout.write('\n');
    console.log(user);
    process.exit();
  }
});
