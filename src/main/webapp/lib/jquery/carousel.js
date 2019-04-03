(function($,window) {
	// el 	: { imgsContainer , prevBtn , nextBtn , indexContainer }
	// conf : { auto , needIndexNum , animateTiming , autoTiming , direction }
	$.fn.carousel = function(options){
		//default param
		const $opt = {
			conf : {
					auto			: true,
					needIndexNum	: true,
					animateTiming	: 1000,
					autoTiming		: 3000,
					direction 		: 'right'
				}
		}

        debugger;
		//init param
		$.extend(true,$opt,options);
		var $this = $(this);
        var $el 	= new Object();
        var $conf = $opt["conf"];
		$.each($opt.el,(index, el) => {
			$el[index] = $this.find(el);
		});
		
		//init dom
		let $imgsNum = $el.imgsContainer.find('li').length;
		for (let i = 1; i <= $imgsNum; i++) {
			$el.indexContainer.append($(`<li>${$conf.needIndexNum ? i : ''}</li>`));
		}

		//get dom
		let $index  = $el.indexContainer.find('li');
		let $images = $el.imgsContainer.find('li');
		
		//init state
		$index.eq(0).addClass('current-index');
		$images.eq(0).fadeIn($conf.animateTiming);

		//get current index
		let getCurrentIndex = () => $el.indexContainer.find('.current-index');
		//get prev element
		let getPrevElement = () => {
			let currentIndex = getCurrentIndex();
			let prev_ = currentIndex.prev();
			return prev_.length ? prev_ : $index.eq($index.length - 1);
		};
		//get next element
		let getNextElement = () => {
			let currentIndex = getCurrentIndex();
			let next_ = currentIndex.next();
			return next_.length ? next_ : $index.eq(0);
		};

		//change image
		let changeImage = (next) => {
			let currentIndex = getCurrentIndex();
			if (currentIndex.index() === next.index()) return;
			$images
			.stop().fadeOut($conf.animateTiming)
			.eq(next.index())
			.stop().fadeIn($conf.animateTiming);
			currentIndex.removeClass('current-index');
			next.addClass('current-index');
		}

		//handle prevBtn click
		$el.prevBtn.on('click', function() {
			changeImage(getPrevElement());
		});

		//handle nextBtn click
		$el.nextBtn.on('click', function() {
			changeImage(getNextElement());
		});

		//handle index click
		$index.on('click', function(){
			changeImage($(this));
		});

		//if auto carousel
		if ($conf.auto) {
			let $timer;

			//auto carousel
			let autoCarousel = () => {
				$timer = window.setInterval(() => {
					if ($conf.direction === 'right') changeImage(getNextElement());
					if ($conf.direction === 'left') changeImage(getPrevElement());
				}, $conf.autoTiming);
			}
			autoCarousel();

			//handle carousel mouseenter
			$this.on('mouseenter', function(event) {
				if ($timer) window.clearInterval($timer);
			});

			//handle carousel mouseleave
			$this.on('mouseleave', function(event) {
				autoCarousel();
			});
		}

	}
})(jQuery,window);