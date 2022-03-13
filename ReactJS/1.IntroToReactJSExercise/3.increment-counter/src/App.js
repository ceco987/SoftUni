import React from 'react'
import './App.css'
import rerender from './index'

let counter = 0
const incrementCounter = () => {
  counter++
  rerender(Counter(), document.getElementById('root'))
}

const Counter = () => (
  <div className="App">
    <header className="App-header">
      {counter}
      <p className="App-header"> 
        <button onClick={incrementCounter}>Click</button>
      </p>
      <a
        className="App-link"
        href="https://reactjs.org"
        target="_blank"
        rel="noopener noreferrer"
      >
        Learn React
      </a>
    </header>
  </div>
)

export default Counter
