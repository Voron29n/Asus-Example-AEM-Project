
(function (window, $, channel, Granite, Coral) {
    "use strict";

    var selectors = {
        dialogContent: ".cmp-images-carousel_v1__editor",
        categories: ".cq-dialog-container__editor-multifield-images_carousel_group",
    };

    $(document).on("dialog-loaded", function (event) {

        var $dialog = event.dialog;

        if ($dialog.length) {
            var dialogContent = $dialog[0].querySelector(selectors.dialogContent);

            if (dialogContent) {
                var categories = dialogContent.querySelector(selectors.categories);

                if (categories) {
                    Coral.commons.ready(categories, function (e) {
                        onCategoriesChange(e);
                    });
                }
            }
        }
    });

    $(document).on("change", selectors.categories, function (e) {
        onChangeAddButton(e);
    });

    function onCategoriesChange(e) {
        disableButton(e);
    }

    function onChangeAddButton(e) {
        let element = e.target;
        disableButton(element);
    }

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

    }

})(window, jQuery, jQuery(document), Granite, Coral);

