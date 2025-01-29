import { useState } from 'react'
import './Counter.css'
export default function Counter(){
    /*
    const buttonStyle = {
        fontSize:"16px",
        backgroundColor:"#00a5ab",
        width: "100px",
        margin:"10px",
        color:"white",
        padding:"15px",
        borderRadius:"30px"
    };
    */
    //margin  creates extra space AROUND an element
    //padding creates extra space WITHIN an element

    // [0,f]
    // const state = useState(0);

    // const array=[1,2]
    // const FirstElement=array[0]
    // const SecondElement=array[1]
    // //or
    // const [FirstElement,SecondElement]=array

    const [count,setCount] = useState(0);
    function incrementCounterFunction(){
        // state[1](state[0]+1)
        // console.log(state[0])
        // console.log(state[1])
        // console.log('increment clicked')
        setCount(count + 1)
        // console.log(count)
    }
    function decrementCounterFunction(){
        setCount(count - 1)
    }
    return(
        <div className="Counter">
            <span className="count">{count}</span>
            <div>
                <button className="counterButton" 
                        onClick={incrementCounterFunction} 
//                        style = {{fontSize:"30px"}} 
//                        style = {buttonStyle}
                >
                    +1
                </button>
                
                <button className="counterButton" 
                        onClick={decrementCounterFunction} 
                >
                    -1
                </button>

            </div>
                    
        </div>
    )
}