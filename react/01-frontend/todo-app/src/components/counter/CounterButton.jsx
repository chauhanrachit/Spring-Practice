import { useState } from 'react';
import './Counter.css';
import {PropTypes} from 'prop-types';

export default function CounterButton({by=1,incrementMethod,decrementMethod}){
    console.log("Received prop 'by':", by);
    console.log("Type of by:", typeof by);

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
    console.log(by);

    function incrementCounterFunction(){
        // state[1](state[0]+1)
        setCount(count + by);
        incrementMethod(by);
    }
    function decrementCounterFunction(){
        setCount(count - by);
        decrementMethod(by);
    }
    return(
        <div className="Counter">
            {/*<span className="count">{count}</span>*/}
            <div>
                <button className="counterButton" onClick={incrementCounterFunction} 
//                        style = {{fontSize:"30px"}} 
//                        style = {buttonStyle}
                >+{by}</button>
                <button className="counterButton" onClick={decrementCounterFunction}>-{by}</button>
            </div>  
        </div>
    )
};


//setting default by defaultProps is not working for some reason, 
//so we are using Explicit Default in Function Parameters
// CounterButton.defaultProps = {
//     by: 1
// };

CounterButton.propTypes = {
    by: PropTypes.number,
};

