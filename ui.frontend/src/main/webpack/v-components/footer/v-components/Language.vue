<template>
    <div>
        <img :src="languageData.fileReference" alt />
        <a :href="languageData.linkTo" :target="languageData.linkUrlTarget">
        </a>
    </div>
</template>

<script>
export default {
    props: {
        languageData: Object
    }
};
</script>

<style lang="scss" scoped>
@import "../v-style/language_default";
@import "../v-style/language_media";
</style>