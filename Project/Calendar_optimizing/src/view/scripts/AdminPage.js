function showContent(id) {
    const contents = document.querySelectorAll('.content');
    contents.forEach(content => content.style.display = 'none');
    document.getElementById(id).style.display = 'block';
}

document.addEventListener('DOMContentLoaded', function() {
    showContent('view-subjects');
});