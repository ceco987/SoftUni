let textInput = '';
textinput = '["PizzaHut - Peter 500, George 300, Mark 800",'
textinput +='"TheLake - Bob 1300, Joe 780, Jane 660"]';
for (const letter of textinput) {
    console.log(`${letter} - ${letter.charCodeAt()}`)
}