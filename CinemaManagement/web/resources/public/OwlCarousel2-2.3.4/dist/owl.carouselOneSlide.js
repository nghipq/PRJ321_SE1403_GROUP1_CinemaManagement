$(document).ready(function() {
    $('.owl-carousel').owlCarousel({
        loop:true,
        margin:0,
        dots: true,
        nav:true,
        autoplay: true,
        autoplayTimeout: 3000,
        responsive:{
            0:{
                items:1
            },
            420:{
                items:2
            },
            600:{
                item: 3    
            },
            1000:{
                items:4
            }
        }
    })   
});