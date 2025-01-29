const person = {
    Name: 'Rachit',
    // address: 'Delhi'
    address: {
        line1: '123 abcde',
        line2: 'fghij 456789',
        city: 'Delhi',
        country: 'India',
    },
    profiles: ['twitter','linkedin','instagram'],
    printProfile: ()=> {
        person.profiles.map(
            // (profile) => {
            //     console.log(profile)
            // }
            profile => console.log(profile)
        )
        console.log(person.profiles[0])
    }
}

// function printProfile(){
//     console.log(person.profiles[0])
// }

export default function LearningJavaScript(){
    return (
        <>
            <div>{person.Name}</div>
            <div>{person.address.line1}</div>
            <div>{person.address.line2}</div>
            <div>{person.address.city}</div>
            <div>{person.address.country}</div>
            <div>{person.profiles[0]}</div>
            <div>{person.printProfile()}</div>
        </>
    )
}