<template>
    <div>
        <h2>{{titleData.groupsTitle}}</h2>
    </div>
</template>

<script>

export default {
    props: {
        titleData: Object,
    },
    
};
</script>

<style lang="scss">
@import "./title_default";
@import "./title_media";
</style>