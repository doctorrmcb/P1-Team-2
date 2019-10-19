function goToCreatePageFromMenu() {
    location.replace(href = 'CreateReimbursementForm/create_reimbursement_form.html');
};

function goToViewManageFromMenu() {
    location.replace(href = 'ViewEditDeleteReimbursementForm/view_manage_reimbursement.html');
};

function goToUpdateForm() {
    location.replace(href = '../UpdatePendingReimbursementForm/Update_Pending_Form.html');
};

function goToViewForm() {
    location.replace(href = '../ViewEditDeleteReimbursementForm/view_manage_reimbursement.html');
};

function LogoutFromMenu() {
    location.replace(href = 'Login/login.html');
};

function LogoutFromCreationForm() {
    location.replace(href = '../Login/login.html');
};

function goFromPageToMenu() {
    location.replace(href = '../central_menu_employee.html');
};

function deleteRow(r) {
    let i = r.parentNode.parentNode.rowIndex;
    document.getElementById("myTable").deleteRow(i);
};

function submittedForm() {
    //alert("The reimbursement form was successfully submitted");
    $('.toast').toast('show')
        //$('.toast').toast(option)
    goToUpdateForm()
};


function dateDisplay() {
    var x = document.getElementById("dob").value;
    document.getElementById("demo").innerHTML = x;
};

function openNav() {
    notification(4);
    document.getElementById("mySidebar").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
};

function closeNav() {
    document.getElementById("mySidebar").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
};

function notification(n) {
    for (let i = 0; i < n; i++) {
        createAnchor();
    }

};


function createAnchor() {
    var para = document.createElement("P");
    para.innerHTML = "message";
    document.getElementById("myCreation").appendChild(para);
}