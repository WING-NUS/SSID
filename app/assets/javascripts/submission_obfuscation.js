(function () {
    let SubmissionObfuscation = {};

    // Retrieve the "obfuscate" parameter from the URL
    let urlParams = new URLSearchParams(window.location.search);
    window.shouldNotObfuscate = (urlParams.get('obfuscate') === 'false');

    SubmissionObfuscation.maskStudentName = function () {

        // Check if the global flag for obfuscation is false; if so, return without obfuscating
        if (window.shouldNotObfuscate) {
            return;
        }

        // Masking inside all h4 elements with id "submission_similarities_for_students" to get the student pairings
        let h4Element = document.querySelector('h4[class="submission_similarities_for_students"]');
        if (h4Element) {
            let match = h4Element.innerHTML.match(/for Students .*? and (.*?) \(\d+\.\d+%\)/);
            if (match && match[1] && match[1] !== '******') {
                let student2Name = match[1];
                h4Element.innerHTML = h4Element.innerHTML.replace(new RegExp("and\\s" + student2Name, "g"), "and ******");
            }
        }

        // Masking h5 elements with the class 'submission2_by_student2'
        let h5Elements = document.querySelectorAll('h5.submission2_by_student2');

        h5Elements.forEach(h5Element => {
            // Adjusted regex to capture student names like Student-02 or x-v6551_q1
            h5Element.innerHTML = h5Element.innerHTML.replace(/Submission by [\w-]+[_\w]*/, 'Submission by ******');
        });

        // Masking inside table header with class "student2_submission" in every table
        let tables = document.querySelectorAll('table');
        tables.forEach(table => {
            let thirdColumnHeader = table.querySelector('th.student2_submission');
            if (thirdColumnHeader) {
                // Adjusted regex to capture student names like Student-02 or x-v6551_q1
                let match = thirdColumnHeader.innerHTML.match(/Submission by ([\w-]+[_\w]*)/);
                if (match && match[1] && match[1] !== '******') {
                    thirdColumnHeader.innerHTML = thirdColumnHeader.innerHTML.replace(match[1], '******');
                }
            }
        });
    };

    // Expose SubmissionObfuscation to the global context
    window.SubmissionObfuscation = SubmissionObfuscation;

}).call(this);
