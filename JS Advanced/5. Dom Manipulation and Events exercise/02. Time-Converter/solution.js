function attachEventsListeners() {
    document.querySelector('main').addEventListener('click', convertFn);
    
    function convertFn(ev) {
        if (ev.target.type == 'button') {
            let allTextFields = Array.from(document.querySelectorAll("input[type='text']"));
            const textField = ev.target.parentNode.querySelector("input[type='text']");
            const unit = Number(textField.value);
            const input = textField.id;
            allTextFields.filter(e=>e.parentNode!=ev.target.parentNode)
                        .forEach(e=>e.parentNode.querySelector("input[type='text']").value=convert(unit,input,e.id));

        }
    }

     function convert(unit, input, output) {
        unit = Number(unit);
        input = input.toLowerCase();
        output = output.toLowerCase();

        const convObj = {
            days: unit * 86400,
            hours: unit * 3600,
            minutes: unit * 60,
            seconds: unit
        }

        let outputValue = convObj[input];   

        const finalObj = {
            days: outputValue / 86400,
            hours: outputValue / 3600,
            minutes: outputValue / 60,
            seconds: outputValue
        }

        return finalObj[output];
    }
}