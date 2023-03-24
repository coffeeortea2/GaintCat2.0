/**
 * 模板的主要js
 */
(function () {
	window.addEventListener('load', function() {
        document.body.classList.add('page-loaded');
    });
	
	/**
	 * header search bar
	 */
    const searchTrigger = document.querySelector('.search-trigger');
    const searchOverlay = document.querySelector('.search-overlay');
    const searchBar = document.querySelector('.navbar-search');
    const searchInput = document.querySelector('.navbar-search input');
    const closeSearch = document.querySelector('.close-search');
    const ACTIVE_SEARCH_CSS_CLASS = 'search-active';
    const HIDDEN_CSS_CLASS = 'd-none';

    function toggleSearch() {

        if (document.body.classList.contains(ACTIVE_SEARCH_CSS_CLASS)) {
            document.body.classList.remove(ACTIVE_SEARCH_CSS_CLASS);
            return;
        }

        searchBar.classList.remove(HIDDEN_CSS_CLASS);
        setTimeout(() => {
            document.body.classList.add(ACTIVE_SEARCH_CSS_CLASS);
            if (searchInput) {
                searchInput.focus();
            }
        }, 150);
    }

    if (searchTrigger) {
        searchTrigger.addEventListener('click', function () {
            toggleSearch();
        });
    }

    if (closeSearch) {
        closeSearch.addEventListener('click', function () {
            toggleSearch();
        });
    }

    if (searchOverlay) {
        searchOverlay.addEventListener('click', function () {
            toggleSearch();
        });
    }
    
    searchInput.addEventListener('keyup', function(event) {
		if (event.keyCode === 13) {
			const val = this.value;
			const pageUrl = new URL(window.location.href);
			const origin = pageUrl.origin;
			const searchURL = origin + '/gaintcat/category?k=' + val;
			location.href = searchURL;
		}
	});
    
    
    /**
	 * AOS
	 * 若該頁面不使用 aos 特效，請於 body 標籤內加入 data-aos-start 標記
	 */
	const aosEl = document.querySelectorAll('[data-aos-start]') || [];
	if(aosEl.length != 0) {
		document.addEventListener('DOMContentLoaded', () => {
			const options = {
				duration: 700,
				easing: 'ease-out-quad',
				once: true,
				startEvent: 'load',
				disable: 'mobile'
			};
			AOS.init(options);
		});
	}
	
	/**
	 * cart
	 */
	const cartWrap = document.querySelector('.dropdown-cart') || '';
	if(cartWrap != '') {
		const closeCartBtns = document.querySelector('.btn-close-cart') || '';
		const cartDropdown = new bootstrap.Dropdown(cartWrap);
		closeCartBtns.addEventListener('click', () => {
			cartDropdown.hide();
		});
	}
})();