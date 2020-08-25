
(function (window, $, channel, Granite, Coral) {
    "use strict";

    var selectors = {
        dialogContent: ".cmp-hero_banner_top_v1__editor",
        images: ".cq-dialog-container__editor-multifield-hero_banner_top",
    };

    $(document).on("dialog-loaded", function (event) {

        var $dialog = event.dialog;

        if ($dialog.length) {
            var dialogContent = $dialog[0].querySelector(selectors.dialogContent);

            if (dialogContent) {
                var images = dialogContent.querySelector(selectors.images);

                if (images) {
                    Coral.commons.ready(images, function (e) {
                        onImagesChange(e);
                    });
                }
            }
        }
    });

    $(document).on("change", selectors.images, function (e) {
        onChangeAddButton(e);
    });

    function onImagesChange(e) {
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

