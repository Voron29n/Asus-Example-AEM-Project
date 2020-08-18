
(function (window, $, channel, Granite, Coral) {
    "use strict";

    var selectors = {
        dialogContent: ".cmp-nav-info-page_v1__editor",
        links: ".cmp-navigation__editor-multifield_actions_nav-info-page",
    };

    $(document).on("dialog-loaded", function (event) {

        var $dialog = event.dialog;

        if ($dialog.length) {
            var dialogContent = $dialog[0].querySelector(selectors.dialogContent);

            if (dialogContent) {
                var links = dialogContent.querySelector(selectors.links);

                if (links) {
                    Coral.commons.ready(links, function (e) {
                        onLinksChange(e);
                    });
                }
            }
        }
    });

    $(document).on("change", selectors.links, function (e) {
        onChangeAddButton(e);
    });

    function onSocialsChange(e) {
        disableButton(e);
    };

    function onCopyrightChange(e) {
        disableButton(e);
    };

    function onLinksChange(e) {
        disableButton(e);
        let links = e.items.getAll();
        jQuery.each(links, function (index, value) {
            let element = this.querySelector(selectors.infolinks);
            disableButton(element);
        });
    };

    function onChangeAddButton(e) {
        let element = e.target;
        disableButton(element);
    };

    function disableButton(element) {

        let validationName = element.getAttribute("data-validation");
        let max = validationName.replace("multifield-max-", "");
        max = parseInt(max);

        if (element.items.length == max) {
            let childs = $('#' + element.id).children();

            jQuery.each(childs, function (index, value) {
                if (value.localName === 'button') {
                    $(value).attr('disabled', 'disabled');
                }
            })
        } else {
            let childs = $('#' + element.id).children();
            jQuery.each(childs, function (index, value) {
                if (value.localName === 'button') {
                    $(value).removeAttr('disabled');
                }
            })
        }

    };


})(window, jQuery, jQuery(document), Granite, Coral);

