var pager = function(options) {

    var defaults = {
        currentPage : 1     
        ,pageSize : 5 
        ,maxListCount : 10 
        ,startnum : 1 
        ,lastnum : 10 
        ,totalCnt : 0 
        ,totalPageCnt : 0
        
    };
    
    this.buttonClickCallback = null;
    this.opts = $.extend({}, defaults, options);
    
};

pager.prototype = {

    "renderpager" : function(totalCnt, buttonClickCallback) {

        //console.log(this);
        //console.log(this.opts);
        var _ = this;
        
        _.opts.totalCnt = totalCnt;
        
        var pageSize = this.opts.pageSize;
        var maxListCount = this.opts.maxListCount;
        var currentPage = this.opts.currentPage;
        
        if (totalCnt == 0) {
            return "";
        }
        
        
        var totalPageCnt = Math.ceil(totalCnt / maxListCount);
    
        
        var n_block = Math.ceil(currentPage / pageSize);

        
        var s_page = (n_block - 1) * pageSize + 1; 
        var e_page = n_block * pageSize;

     
        var $pager = $('#paging');
        $pager.empty(); 


        
        $pager.append(this.renderButton('first', totalPageCnt, _.buttonClickCallback))
              .append(this.renderButton('prev', totalPageCnt,    _.buttonClickCallback));

        
        for (var j = s_page; j <= e_page; j++) {
            if (j > totalPageCnt)    break;
            
            var currentButton = $('<li >' + (j) + '</li>');
            
             
            if (j == currentPage)    currentButton.addClass('selected');
            else currentButton.click(function() {
                                _.initNum(parseInt(this.firstChild.data));
                                _.buttonClickCallback(this.firstChild.data);
                            });
        
            currentButton.appendTo($pager); 
        }

        
        $pager.append(this.renderButton('next', totalPageCnt,    _.buttonClickCallback))
              .append(this.renderButton('last', totalPageCnt,    _.buttonClickCallback));

        return $pager;
    },
    "initNum" : function(cp) {

        this.opts.currentPage = cp;

        
        this.opts.startnum = (cp - 1) * this.opts.maxListCount + 1;

        
        var tmp = cp * this.opts.maxListCount;
        this.opts.lastnum = (tmp > this.opts.totalCnt ? this.opts.totalCnt
                : tmp);

        console.log("P:"+cp+"/startnum:"+this.opts.startnum+"/lastnum:"+this.opts.lastnum);

    },

    "renderButton" : function(buttonLabel, totalPageCnt,
            buttonClickCallback) {
        var _ = this;
        var currentPage = this.opts.currentPage;
        

        var $Button = $('<li >' + buttonLabel + '</li>');
        var destPage = 1;

        
        switch (buttonLabel) {
        case "first":
            destPage = 1;
            $Button.addClass('active');
            $Button.html('<<<<');
            break;

        case "prev":
            destPage = currentPage - 1;
            $Button.addClass('active');
            $Button.html('<<');
            break;

        case "next":
            destPage = currentPage + 1;
            $Button.addClass('active');
            $Button.html('>>');
            break;

        case "last":
            destPage = totalPageCnt;
            $Button.addClass('active');
            $Button.html('>>>>');
            break;
        }

        // disable and 'grey' out buttons if not needed.
        if (buttonLabel == "first" || buttonLabel == "prev") { 

            if(    currentPage <= 1 ) $Button.addClass('pgEmpty').css("display", "none") 
            else $Button.click(function() {    _.initNum(destPage); buttonClickCallback(); });
        } else {
            if( currentPage >= totalPageCnt) $Button.addClass('pgEmpty').css("display", "none")
            else $Button.click(function() { _.initNum(destPage); buttonClickCallback();    });
        }
        return $Button; 
    }
};