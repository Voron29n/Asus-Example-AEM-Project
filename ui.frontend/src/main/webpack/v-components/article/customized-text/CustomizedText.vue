<template>
    <div class="cmc-inner fill">
        <div class="cmc-span">
            <VueTitle :title-data="titleData"></VueTitle>
            <br />
            <VueDescription :description-data="descriptionData"></VueDescription>
            <br />
        </div>
    </div>
</template>

<script>
export default {
    components: {
        VueTitle: () =>
            import(
                /* webpackChunkName: "CustomizedText" */ "./v-components/title/Title"
            ),
        VueDescription: () =>
            import(
                /* webpackChunkName: "CustomizedText" */ "./v-components/description/Description"
            ),
    },
    props: {
        textTitle: {
            type: String,
            required: false,
        },
        textDescription: {
            type: String,
            required: false,
        },
    },
    computed: {
        titleData() {
            return {
                textTitle: this.$props.textTitle,
            };
        },
        descriptionData() {
            return {
                textDescription: this.$props.textDescription,
            };
        },
    },
};

import (/* webpackChunkName: "CustomizedText" */ './v-style/_customized_text_default.scss');
</script>