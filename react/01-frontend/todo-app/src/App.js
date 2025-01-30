import './App.css';
//import LearningComponent from './components/learning-examples/LearningComponent';
import Counter from './components/counter/Counter';

function App() {
  return(
    <div className="App">
      {/*<PlayingWithProps property1="value1" property2="value2"/>*/}
      <Counter />
    </div>
  )
  // return (
  //   <div className="App">
  //     <LearningComponent />
  //   </div>
  // )
}
export default App;
















//Parentheses () make returning complex JSX values easier
//Function Components
//class components
// function PlayingWithProps(properties){
//   console.log(properties)
//   console.log(properties.property1) 
//   console.log(properties.property2) 
//   return(
//     <div></div>
//   )
// }
// function PlayingWithProps({property1,property2}){
// //  console.log(properties)
//   console.log(property1) 
//   console.log(property2) 
//   return(
//     <div></div>
//   )
// }