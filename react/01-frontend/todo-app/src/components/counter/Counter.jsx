import { useState } from 'react';
import './Counter.css';
import CounterButton from './CounterButton';

export default function Counter(){

    const [count,setCount] = useState(0);
    function incrementCounterParentFunction(by){
        setCount(count + by)
    }
    function derementCounterParentFunction(by){
        setCount(count - by)
    }
    function resetCounter(by){
        setCount(0)
    }
    // function someMethodInParent(){
    //     console.log('ParentMethodCalled');
    // }
    return(
        <>
            <span className="totalCount">{count}</span> 
            <CounterButton 
                    incrementMethod={incrementCounterParentFunction} 
                    decrementMethod={derementCounterParentFunction}/>
            <CounterButton by={2} 
                    incrementMethod={incrementCounterParentFunction} 
                    decrementMethod={derementCounterParentFunction}/>
            <CounterButton by={5} 
                    incrementMethod={incrementCounterParentFunction} 
                    decrementMethod={derementCounterParentFunction}/> 
            <button className="resetButton" onClick={resetCounter}>Reset</button>
        </>
    )
}