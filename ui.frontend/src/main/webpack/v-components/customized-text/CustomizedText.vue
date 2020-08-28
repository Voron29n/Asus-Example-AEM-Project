<template>
<div class="cmc-inner fill">
    <div class="cmc-span">
        <v-title :title-data="titleData"></v-title>
        <br>
        <v-description :description-data="descriptionData"></v-description>
        <br>
    </div>
</div>
</template>

<script>
import CustomizedText_TitleCmp from './v-components/title/Title'
import CustomizedText_DescriptionCmp from './v-components/description/Description'

export default {
    components: {
        "v-title": TitleData,
        "v-description": DescriptionData,
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

</script>

<style lang="scss" scoped>
@import "./v-style/customized_text_default";
@import "./v-style/customized_text_media";
</style>