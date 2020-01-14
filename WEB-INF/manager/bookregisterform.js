var status = true;

$(document).ready(function(){
    $("#bookMain").click(function(){
        window.location.href='manager';
    });
    $("#bookList").click(function(){
		window.location.href='booklist';
	});
});

function showMagazine(){
    document.getElementById("magazine_area").className="active";
    document.getElementById("professional_area").className="passive";
    document.getElementById("novel_area").className="passive";
    document.getElementById("children_area").className="passive";
    document.getElementById("foreign_area").className="passive";
    document.getElementById("adult_area").className="passive";
}

function showProfessional(){
    document.getElementById("magazine_area").className="passive";
    document.getElementById("professional_area").className="active";
    document.getElementById("novel_area").className="passive";
    document.getElementById("children_area").className="passive";
    document.getElementById("foreign_area").className="passive";
    document.getElementById("adult_area").className="passive";
}

function showNovel(){
    document.getElementById("magazine_area").className="passive";
    document.getElementById("professional_area").className="passive";
    document.getElementById("novel_area").className="active";
    document.getElementById("children_area").className="passive";
    document.getElementById("foreign_area").className="passive";
    document.getElementById("adult_area").className="passive";
}

function showChildren(){
    document.getElementById("magazine_area").className="passive";
    document.getElementById("professional_area").className="passive";
    document.getElementById("novel_area").className="passive";
    document.getElementById("children_area").className="active";
    document.getElementById("foreign_area").className="passive";
    document.getElementById("adult_area").className="passive";
}

function showForeign(){
    document.getElementById("magazine_area").className="passive";
    document.getElementById("professional_area").className="passive";
    document.getElementById("novel_area").className="passive";
    document.getElementById("children_area").className="passive";
    document.getElementById("foreign_area").className="active";
    document.getElementById("adult_area").className="passive";
}

function showAdult(){
    document.getElementById("magazine_area").className="passive";
    document.getElementById("professional_area").className="passive";
    document.getElementById("novel_area").className="passive";
    document.getElementById("children_area").className="passive";
    document.getElementById("foreign_area").className="passive";
    document.getElementById("adult_area").className="active";
}