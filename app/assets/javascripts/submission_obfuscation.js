(function() {
    let SubmissionObfuscation = {};

    // Retrieve the "obfuscate" parameter from the URL
    let urlParams = new URLSearchParams(window.location.search);
    window.shouldNotObfuscate = (urlParams.get('obfuscate') === 'false');

    // Store the original student2 name
    SubmissionObfuscation.originalStudent2Name = null;

    SubmissionObfuscation.maskStudentName = function() {
        console.log("JS Script here onwards");
        console.log(window.shouldNotObfuscate)
    
        // Check if the global flag for obfuscation is false; if so, return without obfuscating
        if (window.shouldNotObfuscate) {
            console.log("Names are not obfuscated")
            return;
        }
    
        console.log("Masking student name now");
    
        // Masking inside all h4 elements to get the student pairings
        let h4Elements = document.querySelectorAll('h4');
        h4Elements.forEach(h4Element => {
            let match = h4Element.innerHTML.match(/for Students (\w+-\d+) and (\w+-\d+)/);
            if (match && match[1] && match[2] && match[2] !== '******') {
                let student1Name = match[1];
                let student2Name = match[2];
                h4Element.innerHTML = h4Element.innerHTML.replace(new RegExp("and\\s" + student2Name, "g"), "and ******");
            }
        });
        
        // Masking the second h5 for each pair of submissions
        let h5Elements = document.querySelectorAll('h5');
    
        for (let i = 1; i < h5Elements.length; i += 2) {
            h5Elements[i].innerHTML = h5Elements[i].innerHTML.replace(/Student-\d+/, '******');
        }
    
        // Masking inside all table headers in every table
        let tables = document.querySelectorAll('table');
        tables.forEach(table => {
            let thirdColumnHeader = table.querySelector('th.lines_col:nth-child(3)');
            if (thirdColumnHeader) {
                let match = thirdColumnHeader.innerHTML.match(/Submission by (\w+-\d+)/);
                if (match && match[1] && match[1] !== '******') {
                    thirdColumnHeader.innerHTML = thirdColumnHeader.innerHTML.replace(match[1], '******');
                }
            }
        });
    };
    

    /*
    SubmissionObfuscation.onLoad = function() {
        if (!window.shouldNotObfuscate) {
            console.log("On Load called")
            SubmissionObfuscation.maskStudentName();
        }
    };
    */

    // Expose SubmissionObfuscation to the global context
    window.SubmissionObfuscation = SubmissionObfuscation;

}).call(this);
