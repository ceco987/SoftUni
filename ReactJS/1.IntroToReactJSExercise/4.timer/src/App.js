import './App.css';

function time() {
  return new Date().toTimeString().slice(0, 8)
}

function App() {
  return (
    <div className="App">
      {time()}
    </div>
  );
}

export default App;
